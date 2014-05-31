#!/bin/bash

###################################################################################################
###THIS SCRIPT TAKES OUTPUT IN THE CACHECHECKER LOG FILE AND PARSES IT TO A USER FRIENDLY FORMAT###
###################################################################################################

###################################################################################################
###USAGE: ./read_logs.sh <path to directory with CacheChecker.log and CacheChecker.out>############
###DO NOT PASS THE NAME OF THE LOG FILE AS A COMMAND LINE ARGUMENT#################################
###PASS ONLY THE PATH TO THE LOG FILE, SO THE SCRIPT CAN LOCATE IT#################################
###################################################################################################


###################################################################################################
###OUTPUT##########################################################################################
###CacheChecker.log.sorted<timestamp> -- A VERSION OF THE LOG SORTED BY THREAD#####################
###CacheChecker.log.summary<timestamp> -- LOG STATISTICS###########################################
###CacheChecker.log.errors<timestamp> -- ALL ERRORS FOUND IN LOG FILE##############################
###################################################################################################



##VARIABLE DECLARATIONS
TIME=`date +"%T"`
LOG=CacheChecker.log
OUT=CacheChecker.out
DIR=$1
LOG_SORTED=$LOG.sorted.$TIME
LOG_ERRORS=$LOG.errors.$TIME
LOG_SUMMARY=CacheChecker.log.summary.$TIME
CACHES=(commodities drivers equipment equipment-pool orders order-events order-references paperwork order-remarks segments system-dictionaries tenders trips vendors)
CACHE_PREFIX="dist-"
CACHE_NAMES=(Commodity Driver Equipment EquipmentPool Order OrderEvent OrderReference Paperwork OrderRemark Segment SystemDictionary Tender Trip Vendor)
CACHE_NAME_PREFIX="com.hub.cache."



##OUTPUT A VERSION OF THE LOG FILE SORTED BY THREAD NUMBER
##THE PROGRAM IS MULTITHREADED, SO IT DOES NOT LOG EACH CACHE IN SEQUENCE
##PRINTING THE LOG SORTED BY THREAD NUMBER IMPROVES READABILITY
##THE THREAD IS LOGGED IN COLUMN 4, WHERE THE COLUMN DELIMITER IS '|'
sort -t \| -k4.8,4.9n $DIR/$LOG > $DIR/$LOG_SORTED

##PRINT ALL ERRORS SORTED BY CACHE TO AN ERROR FILE
ERRORS=$(grep "Interface object data\|No value for object" $DIR/$LOG | sort -t \| -k4.8,4.9n)
echo "$ERRORS" > $DIR/$LOG_ERRORS

##COLLECT STATISTICS ON THE NUMBER OF MISSING AND MISMATCHED ENTRIES IN EACH CACHE
##PRINT TO THE SUMMARY FILE
MISSING_ENTRIES=$(grep "No value for object from cache" $DIR/$LOG)
DIFFERENT_ENTRIES=$(grep "Interface object data" $DIR/$LOG)
for index in ${!CACHES[*]}
do
  cache="$CACHE_PREFIX${CACHES[$index]}"
  cache_name="$CACHE_NAME_PREFIX${CACHE_NAMES[$index]}"
  echo "$cache"
  echo "$cache_name"
  COUNT_MISSING=`echo "$MISSING_ENTRIES" | grep "$cache" | wc -l`
  COUNT_DIFFERENT=`echo "$DIFFERENT_ENTRIES" | grep "$cache_name" | wc -l`
  echo "$COUNT_MISSING"
  echo "$COUNT_DIFFERENT"
  echo "Number of entries missing from $cache cache: $COUNT_MISSING" >> $DIR/$LOG_SUMMARY
  echo "Number of entries that differ from interface in $cache cache: $COUNT_DIFFERENT" >> $DIR/$LOG_SUMMARY
  TOTAL_COUNT="$(($COUNT_MISSING+$COUNT_DIFFERENT))"
  echo "Total discrepancies in cache $cache are $TOTAL_COUNT" >> $DIR/$LOG_SUMMARY
done




###MISC USEFUL COMMNADS. MAYBE ADD TO SCRIPT AT SOME POINT

#PRINT ALL EQUIPMENT IDS FOR WHICH DAYS ON THE STREET DON'T MATCH B/T CACHE AND INTERFACE -- could make more efficient so we don't pipe awk output to awk
#grep Equipment CacheCehcker.log.errors.16\:14\:40 | grep daysOnTheStreet | awk 'BEGIN { FS = "{" } ; { print $2}' | awk 'BEGIN { FS = "," } ; { print $1 }' | less

# cat file | tr '}' '\n' add newline to routing guide printing