@Library('shared-library') _

pipeline {
	agent any

   	stages {
		stage('Build') {
        		steps {
				vars.helloWorldSimple('Shalini', 'Monday')
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
      	}
}
