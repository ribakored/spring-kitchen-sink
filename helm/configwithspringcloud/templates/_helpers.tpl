{{/*
Expand the name of the chart.
*/}}
{{- define "configwithspringcloud.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{- define "config.client.fullname" -}}
  {{- printf "configclient"  | trunc 63 | trimSuffix "-" }}
{{- end -}}

{{- define "config.server.fullname" -}}
  {{- printf "configserver"  | trunc 63 | trimSuffix "-" }}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "configwithspringcloud.fullname" -}}
{{- if .Values.fullnameOverride }}
{{- .Values.fullnameOverride | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- $name := default .Chart.Name .Values.nameOverride }}
{{- if contains $name .Release.Name }}
{{- .Release.Name | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" }}
{{- end }}
{{- end }}
{{- end }}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "configwithspringcloud.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}


{{/*
Common labels
*/}}
{{- define "configwithspringcloud.labels" -}}
helm.sh/chart: {{ include "configwithspringcloud.chart" . }}
{{ include "configwithspringcloud.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "config.client.labels" -}}
helm.sh/chart: {{ include "configwithspringcloud.chart" . }}
{{ include "config.client.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{- define "config.server.labels" -}}
helm.sh/chart: {{ include "configwithspringcloud.chart" . }}
{{ include "config.server.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}



{{/*
Selector labels
*/}}
{{- define "configwithspringcloud.selectorLabels" -}}
app.kubernetes.io/name: {{ include "configwithspringcloud.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}

{{- define "config.client.selectorLabels" -}}
app.kubernetes.io/name: {{ include "config.client.fullname" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}

{{- define "config.server.selectorLabels" -}}
app.kubernetes.io/name: {{ include "config.server.fullname" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}






{{/*
Create the name of the service account to use
*/}}
{{- define "configwithspringcloud.serviceAccountName" -}}
{{- if .Values.serviceAccount.create }}
{{- default (include "configwithspringcloud.fullname" .) .Values.serviceAccount.name }}
{{- else }}
{{- default "default" .Values.serviceAccount.name }}
{{- end }}
{{- end }}


