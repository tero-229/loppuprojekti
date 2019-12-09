FROM gradle:5.6 as builder
COPY . /java-app
WORKDIR /java-app
RUN gradle bootJar

FROM alpine:3.10
RUN apk add openjdk8
COPY --from=builder /java-app/build/libs/*.jar /java-app.jar
CMD java -jar /java-app.jar
