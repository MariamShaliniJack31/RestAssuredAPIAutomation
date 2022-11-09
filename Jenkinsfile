pipeline {
   agent any

   stages {
	stage('Build') {
        	steps {
			sh '''
        		#!/bin/bash
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
	   
	stage('Deploy') {
		when {
              		expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            	}
		steps {
                	echo currentBuild.result
		}
	}
}
}
