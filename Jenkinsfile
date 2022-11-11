pipeline {
	agent { label "Node_Slave_Linux" }

	parameters {
        	string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
		text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
	        booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
	        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
	        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
		string(name:'DEGREE', defaultValue:'Engg',description:"Write the Bachelors Degree")
    	}
   	stages {
	   
	   stage('Example') {
           	steps {
                	echo "Hello ${params.PERSON}"
	                echo "Biography: ${params.BIOGRAPHY}"
	                echo "Toggle: ${params.TOGGLE}"
                	echo "Choice: ${params.CHOICE}"
	                echo "Password: ${params.PASSWORD}"
            }
        }
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
