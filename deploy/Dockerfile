# FROM clojure as jar
# WORKDIR /usr/src/app
# COPY project.clj /usr/src/app/
# RUN lein deps
# COPY . /usr/src/app
# RUN lein uberjar


# FROM graalvm:afdbbd5 AS native
# WORKDIR /target
# COPY --from=build-jar /usr/src/app/target/clojure-app-bench-0.1.0-SNAPSHOT.jar .
# RUN native-image -jar clojure-app-bench-0.1.0-SNAPSHOT.jar
# RUN mv clojure-app-bench-0.1.0-SNAPSHOT app


# FROM scratch
# COPY --from=native /target/app /
# CMD ["/app"]
# EXPOSE 80
