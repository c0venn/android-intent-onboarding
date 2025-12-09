export interface SendIntentParams {
  orden_id: string;
  monto: number;
  st: string;
  channel: string;
  tipo: string;
}

export interface SendIntentResult {
  status_paid: string;
  order_id: string;
}

export interface OnboardingPlugin {
  sendIntent(options: SendIntentParams): Promise<SendIntentResult>;
}