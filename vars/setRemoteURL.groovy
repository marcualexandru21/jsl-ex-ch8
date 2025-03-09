#!/usr/bin/env groovy

import com.example.Github

def call(String repositoryURL){
    return new Github(this).setRemoteURL(repositoryURL)
}