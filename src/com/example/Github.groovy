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

    def setRemoteURL(String repositoryURL){
        script.withCredentials([usernamePassword(credentialsId: 'github-credentials-ex-ch8-with-token', passwordVariable: 'PASS', usernameVariable: 'USER')]){
            script.sh "git remote set-url origin https://${script.env.USER}:${script.env.PASS}@${repositoryURL}"
        }
    }

    def addCommitAndPushChanges(String branchName){
        script.sh "git add ."
        script.sh 'git commit -m "Version bump"'
        script.sh "git push origin HEAD:${branchName}"
    }

}
