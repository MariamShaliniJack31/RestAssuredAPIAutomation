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
			echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
			echo env.BUILD_NUMBER
			echo env.BUILD_TAG
			echo env.BUILD_URL
			echo env.EXECUTOR_NUMBER
			echo env.JAVA_HOME
			echo env.JENKINS_URL
			echo env.JOB_NAME
			echo env.NODE_NAME
			echo env.WORKSPACE
		}
	}
}
}
