export interface SendIntentParams {
  orden_id: string;
  monto: number;
  st: string;
  channel: string;
  tipo: string;
}

export interface SendIntentResult {
  CLIENT_ORDER_ID: string;
  CLIENT_STATUS: string;
  PAYMENT_RESULT_STATE: string;
}

export interface OnboardingPlugin {
  sendIntent(options: SendIntentParams): Promise<SendIntentResult>;
}