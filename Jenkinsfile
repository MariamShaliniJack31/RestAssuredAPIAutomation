@Library('shared-library') _
pipeline {
	agent any
	vars.evenOdd()
   	stages {
		stage('Build') {
        		steps {
				helloWorldSimple("Shalini", "Monday")
				evenOdd()
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
