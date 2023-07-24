//Build the Docker Image Using the Dockerfile in the root folder

def buildImage() {
    echo "Build Docker Image with Dockerfile..."
    sh 'docker build -t oluwaseuna/demo-app:nodeapp .'
}

//Push Docker Image to DockerHub Repository

def pushImage() {
    echo "Pushing Docker Image to Docker Hub Repo..."
    withCredentials([usernamePassword(credentialsId: 'Docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push oluwaseuna/demo-app:nodeapp'
    }
} 

//Pull Docker Image from DockerHub and Deploy Image to Amazon EC2 Server

def deployImage() {
    echo "Deploying the application to EC2..."
    def dockerComposeCmd = 'docker compose -f docker-compose.yaml up --detach' 
    sshagent(['ec-key']) {
        sh "scp -o StrictHostKeyChecking=no docker-compose.yaml ec2-user@18.130.225.104:/home/ec2-user"
        sh "ssh -o StrictHostKeyChecking=no ec2-user@18.130.225.104 ${dockerComposeCmd}"
    }
} 
return this
