# lumina-cpu-scheduler
Lumina : GPU Scheduler
# Lumina CPU Scheduler Simulator

Lumina is a Java-based simulator that demonstrates how operating systems schedule processes on a CPU.

The project implements multiple scheduling algorithms, simulates resource constraints (VRAM allocation), and evaluates scheduling performance using standard operating system metrics.

## Features

* First Come First Serve (FCFS)
* Shortest Job First (SJF)
* Round Robin Scheduling
* Job Arrival Simulation
* VRAM Resource Management
* Gantt Chart Timeline Visualization
* Scheduling Performance Metrics

## Metrics Calculated

* Waiting Time (WT)
* Turnaround Time (TAT)
* Response Time (RT)
* CPU Utilization
* Throughput

## Example Output

```
Gantt Chart:

| J1 | J5 | J2 | J4 | J3 |

3   12   13   16   19   26
```

## Project Structure

```
src/
 ├── model/        # Core data structures (Job, GanttEntry)
 ├── scheduler/    # Scheduling algorithms
 ├── simulation/   # Workload generator & comparison tools
 ├── metrics/      # Metrics calculation and visualization
 └── resource/     # VRAM manager
```

## How to Run

Compile:

```
javac model/*.java scheduler/*.java simulation/*.java metrics/*.java resource/*.java Main.java
```

Run:

```
java Main
```

## Purpose

This simulator demonstrates key operating system scheduling concepts including:

* Process lifecycle
* CPU scheduling strategies
* Resource allocation
* Performance evaluation

## Future Improvements

* Web-based visualization dashboard
* Interactive Gantt chart
* Priority scheduling
* Multi-core CPU simulation
