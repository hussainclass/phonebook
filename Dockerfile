FROM java:8-jre

ADD ./target/ContactsDemo-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/ContactsDemo-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080