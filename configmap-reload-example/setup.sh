#!/bin/bash
helm delete app1
docker rmi -f $docker$(docker images app1 -aq)

cd app1 &&./gradlew jibDocker
helm install app1 helm/app1/
cd ../

