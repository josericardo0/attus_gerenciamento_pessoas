
FROM openjdk:17-oracle

LABEL maintainer="gmnaarea@gmail.com"

WORKDIR /app

COPY /wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

COPY build/libs/desafio-0.0.1-SNAPSHOT.jar /app/desafio-0.0.1-SNAPSHOT

ENTRYPOINT ["/wait-for-it.sh", "postgres-db:5432", "-t", "60", "--", "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/desafio-0.0.1-SNAPSHOT"]