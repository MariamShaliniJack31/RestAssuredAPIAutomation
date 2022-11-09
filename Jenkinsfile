pipeline {
   agent any

   stages {
		stage('Build') {
        	steps {
			sh '''
            		#!/bin/bash
			sh 'make' 
                	archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
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
