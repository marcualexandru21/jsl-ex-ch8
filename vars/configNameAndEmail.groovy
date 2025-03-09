#!/usr/bin/env groovy

import com.example.Github

def call(String name, String email){
    return new Github(this).configNameAndEmail(name, email)
}