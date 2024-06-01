#!/bin/bash
# Script to wait for a service to be ready

# Usage: ./wait-for-it.sh <host>:<port> [-t timeout] [-- command args]
#   -t TIMEOUT          Timeout in seconds, zero for no timeout
#   -- COMMAND ARGS     Execute command with args after the test finishes

# Example: ./wait-for-it.sh mysql:3306 -- echo "MySQL is up"

hostport=$1
timeout=30
command=()
shift

while [[ $# -gt 0 ]]
do
    case "$1" in
        *:* )
        hostport=$1
        ;;
        -t )
        timeout=$2
        shift
        ;;
        -- )
        shift
        command=("$@")
        break
        ;;
        *)
        echo "Unknown argument: $1"
        exit 1
        ;;
    esac
    shift
done

if [ -z "$hostport" ]; then
    echo "Usage: $0 host:port [-t timeout] [-- command args]"
    exit 1
fi

host=$(echo "$hostport" | cut -d':' -f1)
port=$(echo "$hostport" | cut -d':' -f2)

echo "Waiting for $host:$port to be ready..."

start_ts=$(date +%s)
while :
do
    (echo > /dev/tcp/$host/$port) >/dev/null 2>&1
    result=$?
    if [ $result -eq 0 ]; then
        echo "$host:$port is available after $((`date +%s` - $start_ts)) seconds"
        break
    fi
    sleep 1
    now_ts=$(date +%s)
    if [ $((now_ts - start_ts)) -gt $timeout ]; then
        echo "Timeout reached after $((now_ts - start_ts)) seconds"
        exit 1
    fi
done

if [ ${#command[@]} -gt 0 ]; then
    exec "${command[@]}"
fi
