
### Converting the Line Chart to a Bar Chart

To make the current line chart appear as a bar chart, you simply need to update the `type` of the series in the chart options to `bar`. Here's how you can do it:

#### Updated Code for Bar Chart
```typescript
setupApiUsageChart(): void {
  this.apiUsageChartOptions = {
    title: { text: 'API Usage', fontSize: 18 },
    data: this.apiUsageData,
    series: [
      {
        type: 'bar', // Change this to 'bar' to make it a bar chart
        xKey: 'apiName',
        yKey: 'usageCount',
        fills: ['#4CAF50', '#FFC107', '#2196F3', '#FF5722'], // Optional: Add color fills
        strokeWidth: 0,
      },
    ],
    axes: [
      { type: 'category', position: 'bottom', label: { rotation: 0 } }, // API Names on X-axis
      { type: 'number', position: 'left', title: { text: 'Usage Count' } }, // Usage Counts on Y-axis
    ],
  };
}
```

import { ChartOptions, ChartType, ChartDataset } from 'chart.js';

barChartOptions: ChartOptions = {
  responsive: true,
  scales: {
    x: { title: { display: true, text: 'API Names' } },
    y: { title: { display: true, text: 'Usage Count' } },
  },
};

barChartData: ChartDataset[] = [
  {
    label: 'API Usage',
    data: this.apiUsageData.map(api => api.usageCount),
    backgroundColor: ['#4CAF50', '#FFC107', '#2196F3', '#FF5722'],
  },
];

barChartLabels: string[] = this.apiUsageData.map(api => api.apiName);


---

### Displaying the Charts Side by Side

To display the charts side by side instead of one above the other, you can use a CSS grid or flexbox layout in your HTML. Here's how you can achieve it:

#### Updated HTML for Side-by-Side Layout
```html
<div class="reports-container" style="display: flex; justify-content: space-evenly; align-items: center; gap: 20px;">
  <!-- Feedback Report -->
  <div class="chart-container" style="width: 45%; height: 400px;">
    <h3>Feedback Report</h3>
    <ag-charts-angular
      [options]="feedbackChartOptions"
      style="width: 100%; height: 100%;">
    </ag-charts-angular>
  </div>

  <!-- API Usage -->
  <div class="chart-container" style="width: 45%; height: 400px;">
    <h3>API Usage</h3>
    <ag-charts-angular
      [options]="apiUsageChartOptions"
      style="width: 100%; height: 100%;">
    </ag-charts-angular>
  </div>
</div>
```

---

### Key Adjustments in CSS (Optional)
To refine the layout, you can add these styles in your `component.css` file:

```css
.reports-container {
  display: flex;
  justify-content: space-evenly;
  align-items: flex-start;
  flex-wrap: wrap; /* Optional: Wrap to next line on small screens */
  gap: 20px; /* Space between charts */
}

.chart-container {
  width: 45%;
  min-width: 300px; /* Prevent charts from being too small */
  height: 400px;
}
```

---

### Steps to Implement
1. **Convert to Bar Chart**:
   Replace the `type: 'line'` in your series with `type: 'bar'` as shown above.
   
2. **Modify HTML**:
   Update your HTML to use the side-by-side layout provided.

3. **Test Responsiveness**:
   Resize your browser window to ensure that the charts are still displayed correctly on smaller screens.

---

### Expected Result
With these changes:
- Your API Usage chart will appear as a bar chart.
- The Feedback Satisfaction and API Usage charts will display side by side, evenly spaced, and centered in the container.

Let me know if you need further adjustments!
