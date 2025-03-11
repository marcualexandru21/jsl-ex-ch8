#!/usr/bin/env groovy

package com.example

class Github implements Serializable{
    def script

    Github(script){
        this.script = script;
    }

    def configNameAndEmail(String name, String email){
        script.sh "git config user.name ${name}"
        script.sh "git config user.email ${email}"
    }

    def setRemoteURL(String repositoryURL, String credentialsId){
        script.withCredentials([script.usernamePassword(credentialsId: "${credentialsId}", passwordVariable: 'PASS', usernameVariable: 'USER')]){
            script.sh "git remote set-url origin https://${script.env.USER}:${script.env.PASS}@${repositoryURL}"
        }
    }

    def addCommitAndPushChanges(String branchName){
        script.sh "git add ."
        script.sh 'git commit -m "Version bump"'
        script.sh "git push origin HEAD:${branchName}"
    }

}
