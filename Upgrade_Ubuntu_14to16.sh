#!/bin/bash

# //////////////////////////////////////////////////////////////
#Upgrade Ubuntu 14 to 16
#Ref: https://www.tecmint.com/upgrade-ubuntu-14-04-to-16-04/
# //////////////////////////////////////////////////////////////
sudo apt-get update && sudo apt-get dist-upgrade
sudo apt-get install update-manager-core
sudo do-release-upgrade -d
sudo init 6 
echo "check ubuntu 16 is installed"
lsb_release -a
