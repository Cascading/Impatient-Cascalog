# -*- mode: ruby -*-
# vi: set ft=ruby :

# This Vagrantfile targets the vagrant-lxc provider. It should work on other providers given
# a relatively recent version of Vagrant, but your mileage may vary.

Vagrant.configure("2") do |config|
  config.vm.box = "precise64"

  config.vm.provision :shell, :inline => <<END
# Check if we need to perform a weekly upgrade - this also triggers initial provisioning
touch -d '-1 week' /tmp/.limit

# Install base packages
if [ /tmp/.limit -nt /var/cache/apt/pkgcache.bin ]; then
    apt-get -y remove puppet chef
    apt-get -y autoremove
    apt-get -y update
    apt-get -y dist-upgrade
    apt-get -y install htop tmux vim rsync 
fi
rm /tmp/.limit

# Install basic Java support
if [ ! -x /usr/bin/java ]; then
    apt-get -y install openjdk-7-jre-headless
    echo "export JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64" | tee -a /home/vagrant/.bashrc
fi

# Install leiningen
if [ ! -x /usr/local/bin/lein ]; then
    cd /tmp
    wget https://raw.github.com/technomancy/leiningen/stable/bin/lein
    mv lein /usr/local/bin
    chmod a+x /usr/local/bin/lein 
fi

# Install Hadoop
if [ ! -e /opt/hadoop ]; then
   cd /tmp
   wget http://mirrors.fe.up.pt/pub/apache/hadoop/core/stable/hadoop-2.2.0.tar.gz
   cd /opt
   tar -zxvf /tmp/hadoop-2.2.0.tar.gz
   ln -s hadoop-2.2.0 hadoop
   rm /tmp/hadoop-2.2.0.tar.gz
fi

END
end
