@Library('shared-library') _
pipeline {
	agent any

   	stages {
		stage('Build') {
        		steps {
				echo "hello world"
				mvn -B compile
				
			}
		}
      	
		stage('Test'){
    			steps {
        			mvn -B clean install
			}
      		}
      	}
}
