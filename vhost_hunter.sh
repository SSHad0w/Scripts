#!/bin/sh
echo "Enter the url!: "
read url
gobuster vhost -u $url -w /usr/share/seclists/Discovery/DNS/subdomains-top1million-110000.txt
