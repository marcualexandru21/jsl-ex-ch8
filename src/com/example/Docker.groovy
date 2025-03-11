#!/usr/bin/env groovy

package com.example

class Docker implements Serializable{
    def script

    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName){
        script.echo "Building the docker image"
        script.sh "docker build -t ${imageName} ."
    }

    def dockerHubLogin(String credentialsId){
        script.withCredentials([script.usernamePassword(credentialsId: "${credentialsId}", passwordVariable: 'PASS', usernameVariable: 'USER')]){
            script.sh "echo '${script.env.PASS}' | docker login -u '${script.env.USER}' --password-stdin"
        }
    }

    def dockerPushImage(String imageName){
        script.sh "docker push ${imageName}"
    }

}
