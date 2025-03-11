#!/usr/bin/env groovy

package com.example

class Github implements Serializable{
    def script

    Github(script){
        this.script = script;
    }

    def configNameAndEmail(String name, String email){
        script.sh "git config user.name '${name}'"
        script.sh "git config user.email '${email}'"
    }

    def setRemoteURL(String repositoryURL, String credentialsId){
        script.withCredentials([script.usernamePassword(credentialsId: "${credentialsId}", passwordVariable: 'PASS', usernameVariable: 'USER')]){
            script.sh "git remote set-url origin https://${URLEncoder.encode(script.env.USER, 'UTF-8')}:${URLEncoder.encode(script.env.PASS, 'UTF-8')}@${repositoryURL}"
        }
    }

    def addCommitAndPushChanges(String branchName){
        script.sh "git add ."
        script.sh 'git commit -m "Version bump"'
        script.sh "git push origin HEAD:${branchName}"
    }

}
