# Use an official Node.js runtime as a parent image
FROM node:14

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install project dependencies, including bcrypt
RUN npm install

# Bundle app source
COPY . .

# Expose the port your Node.js application is running on
EXPOSE 3030

# Define the command to start your Node.js application
CMD ["node", "app.js"]
