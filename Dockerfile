FROM openjdk:8-jdk-alpine
ADD app/target/javaclean.jar /javaclean.jar
ENV JAVA_OPTS="-Xms512m -Xmx512m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]