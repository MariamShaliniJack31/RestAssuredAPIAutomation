@Library('shared-library') _
pipeline {
	agent any

   	stages {
		stage('Build') {
        		steps {
				echo "hello world"
				bat 'mvn -B compile'
				
			}
		}
      	
		stage('Test'){
    			steps {
        			bat 'mvn -B clean install'
			}
      		}
      	}
}
