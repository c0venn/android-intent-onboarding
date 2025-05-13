# android-intent-onboarding

android intent for onboarding

## Install

```bash
npm install android-intent-onboarding
npx cap sync
```

## API

<docgen-index>

* [`startActivityForResult(...)`](#startactivityforresult)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### startActivityForResult(...)

```typescript
startActivityForResult(options: { package: string; class: string; value: { [key: string]: any; }; }) => Promise<{ resultCode: number; extras: { [key: string]: any; }; }>
```

| Param         | Type                                                                             |
| ------------- | -------------------------------------------------------------------------------- |
| **`options`** | <code>{ package: string; class: string; value: { [key: string]: any; }; }</code> |

**Returns:** <code>Promise&lt;{ resultCode: number; extras: { [key: string]: any; }; }&gt;</code>

--------------------

</docgen-api>
