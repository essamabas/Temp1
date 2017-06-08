#!/bin/bash

# //////////////////////////////////////////////////////////////
#Upgrade Ubuntu 14 to 16
#Ref: https://www.tecmint.com/upgrade-ubuntu-14-04-to-16-04/
# Read the instruciton in: https://docs.microsoft.com/en-us/azure/service-fabric/service-fabric-get-started-linux
# but replace https with http
# //////////////////////////////////////////////////////////////
sudo sh -c 'echo "deb [arch=amd64] http://apt-mo.trafficmanager.net/repos/servicefabric/ trusty main" > /etc/apt/sources.list.d/servicefabric.list'
sudo sh -c 'echo "deb [arch=amd64] http://apt-mo.trafficmanager.net/repos/dotnet-release/ xenial main" > /etc/apt/sources.list.d/dotnetdev.list'
sudo apt-key adv --keyserver apt-mo.trafficmanager.net --recv-keys 417A0893
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 417A0893
sudo apt-get update
sudo apt-get install servicefabricsdkcommon
sudo echo "servicefabric servicefabric/accepted-eula-v1 select true" | sudo debconf-set-selections
sudo echo "servicefabricsdkcommon servicefabricsdkcommon/accepted-eula-v1 select true" | sudo debconf-set-selections
sudo /opt/microsoft/sdk/servicefabric/common/sdkcommonsetup.sh
sudo apt-get autoclean
sudo apt-get autoremove
