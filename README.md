# Web Traffic Simulator

## How it works
 - Emits a Flux of WebTraffic events of random amounts at random intervals to simulate sudden occasional spikes in web traffic

## Why
 -  This can be a handy tool for learning about back pressure strategies in Project Reactor 

## Docker
 - The Docker image for this project has been built and pushed to DockerHub
 - Pull the image by running: docker pull jc773/traffic-sim:latest
 - Start a running container from the image by running: docker run -p 8080:8080 jc773/traffic-sim:latest
 - Run a simple curl command like this: curl --location 'http://localhost:8080/sim/web/traffic'

## Jar
 - Go to the Actions tab in this repo
 - Click on the latest build
 - Download the Artifact
