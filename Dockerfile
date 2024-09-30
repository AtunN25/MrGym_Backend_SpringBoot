#imagen modelo de donde se implementara el java 21
FROM eclipse-temurin:21-jdk as build

#copiamos nuestro archivo al contenedor
COPY . /app

#definir el directorio raiz de nuestro contenedor
WORKDIR /app

# Ejecuta Maven para empaquetar la aplicación sin correr los tests
RUN ./mvnw package -DskipTests    

# Mueve el JAR generado a "app.jar"
RUN mv -f target/*.jar app.jar      

#Ahora para correr la app
FROM eclipse-temurin:21-jre
ARG PORT
ENV PORT=${PORT}
COPY --from=build /app/app.jar .
RUN useradd runtime
USER runtime
ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]

