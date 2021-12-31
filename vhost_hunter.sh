#!/bin/sh
echo "Enter the url!: "
read url
gobuster vhost -u $url -w /usr/share/seclists/Discovery/DNS/subdomains/-topmillion-110000.txt
