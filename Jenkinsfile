@Library('shared-library') _

pipeline {
	agent any

   	stages {
		stage('Build') {
        		steps {
				
				sh '''
        			#!/bin/bash
				helloWorldSimple("Shalini", "Monday")
				echo "hello world"
				mvn -B compile
				'''
				
			}
		}
      	
		stage('Test'){
    			steps{
        			sh 'mvn -B clean install'
			}
      		}
      	}
}
