package com.nk.test.metric;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.CsvReporter;
import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.MetricSet;
import com.codahale.metrics.jvm.BufferPoolMetricSet;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;

public class CodahaleJmvMetricsExample {
	

	public static void main(String[] args) throws InterruptedException {
		final MetricRegistry registry = setUpRegistry();
		toConsole(registry);
		toCsv(registry);
		Thread.sleep(60000);
		
	//	printAllMetrics();

	}

	private static MetricRegistry setUpRegistry() {
		final  MetricRegistry registry = new MetricRegistry();
		registerAll("gc", new GarbageCollectorMetricSet(), registry);
		registerAll("buffers",new BufferPoolMetricSet(ManagementFactory.getPlatformMBeanServer()), registry);
		registerAll("memory", new MemoryUsageGaugeSet(), registry);
		registerAll("threads", new ThreadStatesGaugeSet(), registry);
		return registry;
	}

	private static void toCsv(MetricRegistry registry) {
		final CsvReporter reporter = CsvReporter.forRegistry(registry)
                .formatFor(Locale.US)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build(new File("D:\\softwares\\workspaces\\workspace-ws\\Measure"));
				reporter.start(1, TimeUnit.SECONDS);
	}

	private static void toConsole(MetricRegistry registry) {
		ConsoleReporter console = ConsoleReporter.forRegistry(registry).convertDurationsTo(TimeUnit.SECONDS)
				.convertRatesTo(TimeUnit.SECONDS).build();
		console.start(5, TimeUnit.SECONDS);
	}

	private static void registerAll(String prefix, MetricSet metricSet,
			MetricRegistry registry) {
		for (Entry<String, Metric> entry : metricSet.getMetrics().entrySet()) {
			if (entry.getValue() instanceof MetricSet) {
				registerAll(prefix + "." + entry.getKey(),
						(MetricSet) entry.getValue(), registry);
			} else {
				registry.register(prefix + "." + entry.getKey(),
						entry.getValue());
			}
		}
	}

	private static void printAllMetrics(MetricRegistry registry) {
		for (String metricName : registry.getGauges().keySet()) {
			printMetric(registry,metricName);
		}
	}

	private static void printMetric(MetricRegistry registry,String metricName) {
		Object value = registry.getGauges().get(metricName).getValue();
		System.out.println("name=" + metricName + ", value=" + value);
	}

}
