FROM amazoncorretto:17.0.5-al2

WORKDIR /app
COPY ./out/artifacts/demo_jar/demo.jar /app

EXPOSE 9003

CMD ["java", "-jar", "/app/demo.jar"]