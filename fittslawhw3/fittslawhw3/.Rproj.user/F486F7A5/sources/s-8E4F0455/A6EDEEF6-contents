#Fitt's Law Experiment

#Reading the csv File
fittslaw_data <- read.csv(file="../data.csv",head=TRUE,sep=",")

#Calculating Mean Time
MT <- aggregate(fittslaw_data[, 1], list(fittslaw_data$D,fittslaw_data$W), mean)

#Finding ID aggregates
IDAggre <- aggregate(fittslaw_data[,2:3], list(fittslaw_data$D,fittslaw_data$W), mean)

#Calculating ID
ID <- log2((IDAggre$D/IDAggre$W)+1)

#Plotting MT vs ID
plot(x=ID,y=MT$x,
     xlab = "ID",
     ylab = "Mean Time")

#Finding regression coefficients
regressionModel = lm(MT$x~ID, data=fittslaw_data)
regressionModel

#Plotting Line using regression coefficients
abline(regressionModel, col="red")

#Calculating throughput
ThPut = ID/MT$x

#Plotting throughput vs ID
plot(x=ID,y=ThPut,
     xlab = "ID",
     ylab = "Through Put")

#Finding regression coefficients for ThroughPut
regressionModelThPut = lm(ThPut~ID, data=fittslaw_data)
regressionModelThPut

#Plotting Line using regression coefficients
abline(regressionModelThPut, col="blue")




