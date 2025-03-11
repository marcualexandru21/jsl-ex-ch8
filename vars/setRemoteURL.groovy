#!/usr/bin/env groovy

import com.example.Github

def call(String repositoryURL, String credentialsId){
    return new Github(this).setRemoteURL(repositoryURL, credentialsId)
}
