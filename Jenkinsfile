@Library('shared-library') _

pipeline {
	agent any

   	stages {
		stage('Build') {
        		steps {
				helloWorldSimple("Shalini","Monday")
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
