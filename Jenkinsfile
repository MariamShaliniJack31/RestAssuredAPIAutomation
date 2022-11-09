pipeline {
   agent any

   stages {
		stage('Build') {
        	steps {
			sh '''
            		#!/bin/bash
			
            		echo "hello world"
			mvn -B compile
			junit "**/target/*.xml"
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
