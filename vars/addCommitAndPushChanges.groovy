#!/usr/bin/env groovy

import com.example.Github

def call(String branchName){
    return new Github(this).addCommitAndPushChanges(branchName)
}