@Library('shared-library') _
pipeline {
	agent any
	
   	stages {
		stage('Build') {
        		steps {
				helloWorldSimple.call("Shalini", "Monday")
				helloWorldSimple.calling("Rufus", "Tuesday")
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
