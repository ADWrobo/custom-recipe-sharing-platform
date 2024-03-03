# custom-recipe-sharing-platform

## Purpose
This is the final group project for SEIS739 - Software Analysis, Design, and Implementation. This is a simple Java Spring Boot application.

This application uses:
* Java Version 21
* maven:3.9.6-sapmachine-21
* openjdk:21

See the Dockerfile and docker-compose.yml for more details.

## Getting Started
In order to get this running, there are a few steps you need to take.
* Clone this repository into a local directory.
* Ensure Docker desktop is installed on your host.
* This project's `application.properties` and `docker-compose` uses environment variables for connecting to an Avien MySQL server:
    * Be sure to add the DB username and password as environment variables to your BASH profile!
    * Additionally, set up a .env file in the same directory as your docker-compose.yml, and add the environment variables there:
        * export CRSP_DB_USERNAME=example
        * export CRSP_DB_PASSWORD=example
    * DO NOT add the .env file to any public repository!
    * If you are not pushing changes to `application.properties` to a public repo, I _suppose_ you could hardcode these values...
* From the `custom-recipe-sharing-platform` directory, run `docker-compose build` - this will build the Docker image.
* Now run `docker-compose up -d` - this will run the Docker container (`-d` will allow you to perform CL actions within the container).
* Access the running application by navigating to `https://localhost:8080/` in a web browser.

## Example Actions
Running CL actions within the container is easy! Use `docker-compose exec` as the prefix.

Adding data to the database is also easy, turns out! An example might be `curl http://localhost:8080/jemo/add -d name="Sponge Bob" -d email=bob@crabby.com
` - note that this does _not_ need to be run within the docker container.

Navigate to `https://localhost:8080/custom-recipe-sharing-platform/all` to see data.

## Credits
We used the following tutorials to help in setting this up:
* https://aiven.io/developer/create-a-spring-boot-application-with-a-mysql-backend

Other useful documentation can be found here:
* https://hub.docker.com/

[//]: # (TODO: We will want to consider how to implement the database.)
