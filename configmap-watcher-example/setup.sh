#!/bin/bash

#  minikube start --driver=hyperkit --container-runtime=docker && eval $(minikube -p minikube docker-env)
helm delete app1
helm delete app2
docker rmi -f $docker$(docker images app1 -aq)
docker rmi -f $docker$(docker images app2 -aq)

kubectl apply -f shared-configmap.yaml
cd app1 &&./gradlew jibDocker
helm install app1 helm/app1/
cd ../

cd app2 && ./gradlew jibDocker
helm install app2 helm/app2/
cd ../

