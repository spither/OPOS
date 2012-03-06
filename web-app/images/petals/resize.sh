#!/bin/bash

size="x40"

convert 10-health.png -resize $size health.png
convert 09-equity.png -resize $size equity.png
convert 08-culture.png -resize $size culture.png
convert 07-land-use.png -resize $size land.png
convert 06-water.png -resize $size water.png
convert 05-food.png -resize $size food.png
convert 04-materials.png -resize $size materials.png
convert 03-transport.png -resize $size transport.png
convert 02-zero-waste.png -resize $size waste.png
convert 01-zero-carbon.png -resize $size carbon.png

optipng [a-z]*.png
