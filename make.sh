#!/bin/sh
mkdir -p /usr/local/certificateGenerator/
mkdir -p /usr/local/certificateGenerator/cache
mkdir -p /usr/local/certificateGenerator/keystore
mkdir -p /usr/local/certificateGenerator/certificate
cp ./certificateGenerator.sh /usr/local/certificateGenerator/
cp ./target/certificate-generator-v1.0.5.jar /usr/local/certificateGenerator/certificate-generator.jar


