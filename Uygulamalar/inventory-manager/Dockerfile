FROM adoptopenjdk/openjdk11

RUN groupadd -r spring && useradd --no-log-init -m -r -g spring spring

USER spring:spring

# Create app directory (with user `spring`)
RUN mkdir -p /home/spring/app

RUN mkdir -p /home/spring/.m2

ARG SETTINGS_XML
COPY --chown=spring ${SETTINGS_XML} /home/spring/.m2/

WORKDIR /home/spring/app

COPY --chown=spring mvnw .
COPY --chown=spring .mvn .mvn
COPY --chown=spring pom.xml .
COPY --chown=spring src src



RUN ./mvnw install -DskipTests --quiet

FROM adoptopenjdk/openjdk11

RUN groupadd -r spring && useradd --no-log-init -m -r -g spring spring

USER spring:spring

# Create app directory (with user `spring`)
RUN mkdir -p /home/spring/app

WORKDIR /home/spring/app

LABEL tr.com.atez.sign.document="sign-document"

COPY --chown=spring --from=build /home/spring/app/target/inventory-manager-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080
EXPOSE ${PORT}