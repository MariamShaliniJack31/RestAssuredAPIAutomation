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
			echo "BUILD_NUMBER : ${env.BUILD_NUMBER}"
			echo "BUILD_TAG : ${env.BUILD_TAG}"
			echo "BUILD_URL : ${env.BUILD_URL}"
			echo "EXECUTOR_NUMBER : ${env.EXECUTOR_NUMBER}"
			echo "JAVA_HOME : ${env.JAVA_HOME}"
			echo "JENKINS_URL : ${env.JENKINS_URL}"
			echo "JOB_NAME : ${env.JOB_NAME}"
			echo "NODE_NAME : ${env.NODE_NAME}"
			echo "WORKSPACE : ${env.WORKSPACE}"
		}
	}
}
}
